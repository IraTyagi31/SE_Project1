package Main;
import java.util.Vector;
import java.io.*;

//import Lane.*;
//import Main.*;
import ControlDesk.*;
//import PinSetter.*;
//import Score.*;

public class drive {

	public static void main(String[] args) {

		int numLanes = 3;
		int maxPatronsPerParty=5;

//		Alley a = new Alley( numLanes );
//		ControlDesk controlDesk = a.getControlDesk();
		
		ControlDesk controlDesk =new ControlDesk( numLanes );

		ControlDeskView cdv = new ControlDeskView( controlDesk, maxPatronsPerParty);
// 		controlDesk.subscribe( cdv );

	}
}
