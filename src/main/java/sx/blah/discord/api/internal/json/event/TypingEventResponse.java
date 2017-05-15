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

package sx.blah.discord.api.internal.json.event;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import sx.blah.discord.api.internal.IDDeserializer;
import sx.blah.discord.api.internal.IDSerializer;

/**
 * A response sent when a user starts typing
 */
public class TypingEventResponse {

	/**
	 * The user's id who started typing
	 */
	@JsonSerialize(using = IDSerializer.class)
	@JsonDeserialize(using = IDDeserializer.class)
	public long user_id;

	/**
	 * The timestamp when the event was launching, in epoch milliseconds
	 */
	public int timestamp;

	/**
	 * The channel id for where this is occurring
	 */
	@JsonSerialize(using = IDSerializer.class)
	@JsonDeserialize(using = IDDeserializer.class)
	public long channel_id;
}
