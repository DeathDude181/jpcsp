/*
This file is part of jpcsp.

Jpcsp is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Jpcsp is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Jpcsp.  If not, see <http://www.gnu.org/licenses/>.
 */
package jpcsp.format.rco.vsmx.objects;

import jpcsp.format.rco.vsmx.interpreter.VSMXBaseObject;
import jpcsp.format.rco.vsmx.interpreter.VSMXFunction;
import jpcsp.format.rco.vsmx.interpreter.VSMXInterpreter;
import jpcsp.format.rco.vsmx.interpreter.VSMXObject;

public class BaseNativeObject {
	private VSMXObject object;

	public VSMXObject getObject() {
		return object;
	}

	public void setObject(VSMXObject object) {
		this.object = object;
	}

	public void callCallback(VSMXInterpreter interpreter, String name, VSMXBaseObject[] arguments) {
		VSMXBaseObject function = getObject().getPropertyValue(name);
		if (function instanceof VSMXFunction) {
			interpreter.interpretFunction((VSMXFunction) function, null);
		}
	}

	@Override
	public String toString() {
		return getClass().getSimpleName();
	}
}
