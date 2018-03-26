package data.hullmods;

import com.fs.starfarer.api.combat.HullModEffect;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;
import com.fs.starfarer.api.fleet.FleetMemberAPI;

class BaseHullMod implements HullModEffect {

  @Override
  public boolean affectsOPCosts() {
    return false;
  }

  @Override
  public void applyEffectsBeforeShipCreation(
      HullSize hullSize, MutableShipStatsAPI stats, String id) {}

  @Override
  public void applyEffectsAfterShipCreation(ShipAPI ship, String id) {}

  @Override
  public String getDescriptionParam(int index, HullSize hullSize) {
    return null;
  }

  @Override
  public String getDescriptionParam(int index, HullSize hullSize, ShipAPI ship) {
    return null;
  }

  @Override
  public boolean isApplicableToShip(ShipAPI ship) {
    return false;
  }

  @Override
  public String getUnapplicableReason(ShipAPI ship) {
    return null;
  }

  @Override
  public void advanceInCampaign(FleetMemberAPI member, float amount) {}

  @Override
  public void advanceInCombat(ShipAPI ship, float amount) {}
}
