package com.example.auto_parts.spare.service;

import com.example.auto_parts.spare.Spare;
import com.example.auto_parts.spare.service.dto.SpareFilterReqt;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class SpareRepositoryMixinImpl implements SpareRepositoryMixin{
    private final EntityManager em;

    @Transactional
    @Override
    public List<Spare> search_spare(SpareFilterReqt body) {
        var query = em.createNamedStoredProcedureQuery("search_spare");
        System.out.println("*********");
        System.out.println(body.getModelId());
        String category = null;
        if (body.getCategory() != null) {
            category = body.getCategory().getName();
        }
        int index = 3;
        query.setParameter(index++, body.getVendorCode());
        query.setParameter(index++, body.getName());
        query.setParameter(index++, category);
        query.setParameter(index++, body.getModelId());
        query.setParameter(index++, body.getBrandId());

        query.setParameter(index++, body.getCurrentPage());
        query.setParameter(index++, body.getShowPerPage());


        query.execute();

        var result = query.getResultList();
        var total = (Long) query.getOutputParameterValue(2);

        return result;
    }


    private static long[] toLongArray(Collection<Long> source) {
        if (source == null)
            return new long[0];

        return source.stream().mapToLong(Number::longValue).distinct().toArray();
    }
}
