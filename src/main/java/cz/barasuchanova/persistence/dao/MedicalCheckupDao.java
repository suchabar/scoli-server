package cz.barasuchanova.persistence.dao;

import cz.barasuchanova.persistence.IEntityManagerProvider;
import cz.barasuchanova.persistence.model.MedicalCheckup;

public class MedicalCheckupDao extends GenericDao<MedicalCheckup> {
    public MedicalCheckupDao(IEntityManagerProvider entityManagerProvider) {
        super(MedicalCheckup.class, entityManagerProvider);
    }
}

