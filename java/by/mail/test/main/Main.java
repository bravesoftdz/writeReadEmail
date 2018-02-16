package by.mail.test.main;

import java.io.IOException;

import by.mail.test.constants.Constants;
import by.mail.test.logic.LogicChrome;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {

		Constants con = new Constants();
		LogicChrome logicChrome = new LogicChrome();
		logicChrome.processSendWriteEmailChrome(con.user, con.password, con.email);
		
		
	}

}
