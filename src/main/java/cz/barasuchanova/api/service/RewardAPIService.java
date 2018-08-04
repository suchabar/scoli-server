package cz.barasuchanova.api.service;

import cz.barasuchanova.persistence.DaoWrapper;
import cz.barasuchanova.persistence.model.Reward;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.ws.rs.core.Response;

@FieldDefaults(level = AccessLevel.PRIVATE)
public enum RewardAPIService
{
    INSTANCE;
    DaoWrapper daoWrapper = DaoWrapper.INSTANCE;

    public Response create(Reward reward) {
        try {
            daoWrapper.getRewardDao().create(reward);
            return Response.ok(reward).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    public Response read(Integer id) {
        try {
            final Reward reward = daoWrapper.getRewardDao().read(id);
            return Response.ok(reward).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    public Response update(Integer id, Reward reward) {
        try {
            final Reward rewardFromDB = daoWrapper.getRewardDao().read(id);
            rewardFromDB.setChild(reward.getChild());
            rewardFromDB.setStoreItem(reward.getStoreItem());
            rewardFromDB.setDatePurchased(reward.getDatePurchased());
            daoWrapper.getRewardDao().update(rewardFromDB);
            return Response.ok(rewardFromDB).build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    public Response delete(Integer id) {
        try {
            final Reward reward = daoWrapper.getRewardDao().read(id);
            daoWrapper.getRewardDao().delete(reward);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}
