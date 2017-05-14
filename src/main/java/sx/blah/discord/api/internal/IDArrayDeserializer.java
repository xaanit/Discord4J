/*
 *     This file is part of Discord4J.
 *
 *     Discord4J is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Discord4J is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with Discord4J.  If not, see <http://www.gnu.org/licenses/>.
 */

package sx.blah.discord.api.internal;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class IDArrayDeserializer extends StdDeserializer<long[]> {
	
	public IDArrayDeserializer() {
		super(long[].class);
	}
	
	@Override
	public long[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
		JsonToken t = jsonParser.getCurrentToken();
		
		if (t == JsonToken.VALUE_NULL)
			return new long[0];
		
		List<Long> longs = new LinkedList<>();
		if (t == JsonToken.START_ARRAY) {
			while (JsonToken.END_ARRAY != jsonParser.nextToken()) {
				longs.add(Long.parseUnsignedLong(jsonParser.getText()));
			}
		}
		
		long[] longArray = new long[longs.size()];
		int i = 0;
		for (Long aLong : longs) {
			longArray[i] = aLong;
			i++;
		}
		return longArray;
	}
}
