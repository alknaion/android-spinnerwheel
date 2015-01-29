/*
 * android-spinnerwheel
 * https://github.com/ai212983/android-spinnerwheel
 *
 * based on
 *
 * Android Wheel Control.
 * https://code.google.com/p/android-wheel/
 *
 * Copyright 2011 Yuri Kanivets
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package antistatic.spinnerwheel.adapters;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

import android.content.Context;

public class MapWheelAdapter<KEY_TYPE, VALUE_TYPE> extends AbstractWheelTextAdapter {

	// items
	private final Map<KEY_TYPE, VALUE_TYPE> mItemsMap;
	private final Vector<Entry<KEY_TYPE, VALUE_TYPE>> mItemsList;

	public MapWheelAdapter(Context context, Map<KEY_TYPE, VALUE_TYPE> itemsMap) {
		super(context);
		this.mItemsMap = itemsMap;
		mItemsList = new Vector<Entry<KEY_TYPE, VALUE_TYPE>>(itemsMap.entrySet());
	}

	@Override
	public CharSequence getItemText(int index) {
		if (index >= 0 && index < mItemsMap.size()) {
			final Entry<KEY_TYPE, VALUE_TYPE> item = mItemsList.get(index);
			final VALUE_TYPE value = item.getValue();
			if (value instanceof CharSequence) {
				return (CharSequence) value;
			}
			return value.toString();
		}
		return null;
	}

	@Override
	public int getItemsCount() {
		return mItemsMap.size();
	}

	public KEY_TYPE getKeyByPosition(int position) {
		return mItemsList.get(position).getKey();
	}
}
