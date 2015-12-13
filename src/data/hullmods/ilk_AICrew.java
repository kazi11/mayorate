package data.hullmods;

import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI;

public class ilk_AICrew extends BaseHullMod {

    public static final float PERCENT_AI_CREW = 0.5f;
    public static final float AI_EFFICIENCY = 0.05f;

    @Override
    public void applyEffectsBeforeShipCreation(ShipAPI.HullSize hullSize, MutableShipStatsAPI stats, String id) {
        //crew mods
        stats.getCrewLossMult().modifyMult(id, PERCENT_AI_CREW);
        stats.getMinCrewMod().modifyMult(id, PERCENT_AI_CREW);
        stats.getMaxCrewMod().modifyMult(id, PERCENT_AI_CREW);

        //weapon mods
        stats.getAutofireAimAccuracy().modifyFlat(id, AI_EFFICIENCY);

        //engine mods
        stats.getAcceleration().modifyMult(id, 1f + AI_EFFICIENCY);
        stats.getDeceleration().modifyMult(id, 1f + AI_EFFICIENCY);
        stats.getTurnAcceleration().modifyMult(id, 1f + AI_EFFICIENCY);

        //logistical penalties
        stats.getRepairRatePercentPerDay().modifyMult(id, PERCENT_AI_CREW);
    }

    @Override
    public String getDescriptionParam(int index, ShipAPI.HullSize hullSize) {
        switch (index) {
            case 0:
                return "" + (int) (PERCENT_AI_CREW * 100f);
            case 1:
                return "" + (int) (AI_EFFICIENCY * 100f);
            case 2:
                return "" + (int) (PERCENT_AI_CREW * 100f);
            default:
                return null;
        }
    }
}
