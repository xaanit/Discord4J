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

package sx.blah.discord.api.internal.json.objects;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import sx.blah.discord.api.internal.IDDeserializer;
import sx.blah.discord.api.internal.IDSerializer;

/**
 * Represents a json voice state object.
 */
public class VoiceStateObject {
	/**
	 * The guild id of the voice state.
	 */
	@JsonSerialize(using = IDSerializer.class)
	@JsonDeserialize(using = IDDeserializer.class)
	public long guild_id;
	/**
	 * The voice channel id of the voice state.
	 */
	@JsonSerialize(using = IDSerializer.class)
	@JsonDeserialize(using = IDDeserializer.class)
	public Long channel_id;
	/**
	 * The user id with the state.
	 */
	@JsonSerialize(using = IDSerializer.class)
	@JsonDeserialize(using = IDDeserializer.class)
	public long user_id;
	/**
	 * The session id of the voice state.
	 */
	public String session_id;
	/**
	 * Whether the user is deafened.
	 */
	public boolean deaf;
	/**
	 * Whether the user is muted.
	 */
	public boolean mute;
	/**
	 * Whether the user has deafened themselves.
	 */
	public boolean self_deaf;
	/**
	 * Whether the user has muted themselves.
	 */
	public boolean self_mute;
	/**
	 * Whether user is suppressed.
	 */
	public boolean suppress;
}
