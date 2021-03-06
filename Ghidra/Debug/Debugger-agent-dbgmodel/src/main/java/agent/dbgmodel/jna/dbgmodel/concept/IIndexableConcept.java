/* ###
 * IP: GHIDRA
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package agent.dbgmodel.jna.dbgmodel.concept;

import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Guid.IID;
import com.sun.jna.platform.win32.WinDef.ULONGLONG;
import com.sun.jna.platform.win32.WinDef.ULONGLONGByReference;
import com.sun.jna.platform.win32.WinNT.HRESULT;
import com.sun.jna.ptr.PointerByReference;

import agent.dbgmodel.jna.dbgmodel.IUnknownEx;
import agent.dbgmodel.jna.dbgmodel.UnknownWithUtils.VTableIndex;

public interface IIndexableConcept extends IUnknownEx {
	final IID IID_IINDEXABLE_CONCEPT = new IID("D1FAD99F-3F53-4457-850C-8051DF2D3FB5");

	enum VTIndices implements VTableIndex {
		GET_DIMENSIONALITY, //
		GET_AT, //
		SET_AT, //
		;

		static int start = 3;

		@Override
		public int getIndex() {
			return this.ordinal() + start;
		}
	}

	HRESULT GetDimensionality(Pointer contextObject, ULONGLONGByReference dimensionality);

	HRESULT GetAt(Pointer contextObject, ULONGLONG indexerCount, Pointer[] indexers,
			PointerByReference object, PointerByReference metadata);

	HRESULT SetAt(Pointer contextObject, ULONGLONG indexerCount, PointerByReference indexers,
			Pointer value);

}
