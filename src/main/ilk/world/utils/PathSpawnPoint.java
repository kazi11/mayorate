package ilk.world.utils;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.CampaignFleetAPI;
import com.fs.starfarer.api.campaign.FactionAPI;
import com.fs.starfarer.api.campaign.LocationAPI;
import com.fs.starfarer.api.campaign.SectorAPI;
import com.fs.starfarer.api.campaign.SectorEntityToken;
import com.fs.starfarer.api.impl.campaign.ids.Factions;

import org.apache.log4j.Level;

public class PathSpawnPoint extends BaseSpawnPoint {

  FactionAPI path;
  private static final float PATH_SPAWN_CHANCE = 0.5f;

  public PathSpawnPoint(SectorAPI sector, LocationAPI location, float daysInterval, int maxFleets,
      SectorEntityToken anchor) {
    super(sector, location, daysInterval, maxFleets, anchor);
    path = Global.getSector().getFaction(Factions.LUDDIC_PATH);

    Global.getLogger(PathSpawnPoint.class).setLevel(Level.ALL);
  }

  @Override
  protected CampaignFleetAPI spawnFleet() {
    CampaignFleetAPI fleet = Global.getFactory().createEmptyFleet("luddic_path", "pathFleet", true);

    double rand = 0f;
    while (rand < PATH_SPAWN_CHANCE) {
      rand = Math.random();
      // TODO is FactionAPI.ShipPickParams() the right choice here?
      path.pickShipAndAddToFleet("combatSmall", new FactionAPI.ShipPickParams(), fleet);
    }

    Global.getLogger(PathSpawnPoint.class).log(Level.DEBUG,
        "Spawned path fleet w/ " + fleet.getFleetData().getMembersListCopy().size() + " members.");
    getLocation().spawnFleet(getAnchor(), 0, 0, fleet);

    return fleet;
  }
}
