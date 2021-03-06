package haw;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import de.uniba.wiai.lspi.chord.data.ID;

public class StupidRandomStrategy implements Strategy {
	Random rnd = new Random();

	/**
	 * strategy to place ships:<br />
	 * putting all ships to unique random positions
	 */
	@Override
	public ArrayList<Ship> placeMyShipsOnLogicalPositions() {
		System.out.println("ADDING " + Starter.AMOUNT_OF_SHIPS + " SHIPS ON LOGICAL POSITIONS BETWEEN 0 AND " + Starter.AMOUNT_OF_LOGICAL_POSITIONS);

		// Helper data structure to avoid duplicates
		Map<Integer, Ship> ships = new HashMap<Integer, Ship>();

		while (ships.size() < Starter.AMOUNT_OF_SHIPS) {

			// determine the logical position usind the random function
			int pos = rnd.nextInt(Starter.AMOUNT_OF_LOGICAL_POSITIONS);

			// only one ship per position
			if (!ships.containsKey(pos)) {

				// generates a new instance of an ship on the desired position
				Ship s = new Ship(pos);
				ships.put(pos, s);
			}
		}

		// Returning a list of ships with logical positions set
		return new ArrayList<Ship>(ships.values());
	}

	/**
	 * stupid strategy (including friendly fire)
	 */
	@Override
	public ID determineTarget() {

		ID target = ID.valueOf(new BigInteger(160, new Random()));

		return target;
	}
}
