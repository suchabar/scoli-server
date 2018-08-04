package cz.barasuchanova.persistence.dao;

import cz.barasuchanova.persistence.IEntityManagerProvider;
import cz.barasuchanova.persistence.model.Reward;

public class RewardDao extends GenericDao<Reward> {
    public RewardDao(IEntityManagerProvider entityManagerProvider) {
        super(Reward.class, entityManagerProvider);
    }
}

