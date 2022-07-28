CREATE OR REPLACE FUNCTION public.search_spare(
    OUT o_result refcursor,
    OUT o_total bigint,
    --
    p_vendor_code   bigint,
    p_name     text,
    p_category    text,
    p_model_id   bigint,
    p_brand_id   bigint,
    p_page integer,
    p_per_page integer
)
    RETURNS record
    LANGUAGE plpgsql
AS $function$
declare
l_temp   int8[];
    l_offset int8 := p_page * p_per_page;

    l_query  text := '';
begin

    l_query := '
		select 
		array_agg(t.vendor_code)
		--model.id 
		from t_spare t 
	    left join t_spare_models mod on mod.spare_id = t.vendor_code
	    left join t_model model on model.id = mod.model_id
 		left join t_brand br on br.id = model.brand_id
        where true
		--group by 
		--t.vendor_code
	
    ';

    if p_vendor_code is not null then
        l_query := l_query || '
            and t.vendor_code = $1
        ';
	end if;
	
	    if p_name is not null then
	        l_query := l_query || '
	            and t.name = $2
	        ';
	end if;

    if p_category is not null then
        l_query := l_query || '
            and t.category = $3
        ';
end if;

	if p_model_id is not null then
	        l_query := l_query || '
	            and model.id = $4
	        ';
	end if;

	if p_brand_id is not null then
	        l_query := l_query || '
	            and br.id = $5
	        ';
	end if;


execute l_query into l_temp
    using /* 1 */ p_vendor_code,
        /* 2 */ p_name,
        /* 3 */ p_category,
        /* 4 */ p_model_id,
        /* 5 */	p_brand_id
;


o_total := coalesce(cardinality(l_temp), 0);

open o_result for
select distinct t.*
from unnest(l_temp) f
         join t_spare t
              on t.vendor_code = f
order by t.vendor_code
    limit p_per_page offset l_offset
;

end;
$function$
;
