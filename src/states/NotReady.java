package states;

import events.CheckAllZones;
import timer.Notifiable;

/**
 * 
 * @author Brahma Dathan and Sarnath Ramnath
 * @Copyright (c) 2010
 * 
 *            Redistribution and use with or without modification, are permitted
 *            provided that the following conditions are met:
 *
 *            - the use is for academic purpose only - Redistributions of source
 *            code must retain the above copyright notice, this list of
 *            conditions and the following disclaimer. - Neither the name of
 *            Brahma Dathan or Sarnath Ramnath may be used to endorse or promote
 *            products derived from this software without specific prior written
 *            permission.
 *
 *            The authors do not make any claims regarding the correctness of
 *            the code in this module and are not responsible for any loss or
 *            damage resulting from its use.
 */

public class NotReady extends SecurityState implements Notifiable {
	private static NotReady instance;

	/**
	 * Private constructor for the singleton pattern
	 */
	private NotReady() {
	}

	public static NotReady instance() {
		if (instance == null) {
			instance = new NotReady();
		}
		return instance;
	}

	@Override
	public void handleEvent(CheckAllZones event) {
		SecurityContext.instance().changeState(Ready.instance());
	}

	@Override
	public void enter() {
		SecurityContext.instance().showNotReady();
	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub

	}
}