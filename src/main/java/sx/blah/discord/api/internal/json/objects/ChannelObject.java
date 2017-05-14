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
 * Represents a json channel object.
 */
public class ChannelObject {
	/**
	 * The id of the channel.
	 */
	@JsonSerialize(using = IDSerializer.class)
	@JsonDeserialize(using = IDDeserializer.class)
	public long id;
	/**
	 * The id of the guild this channel is in.
	 */
	@JsonSerialize(using = IDSerializer.class)
	@JsonDeserialize(using = IDDeserializer.class)
	public long guild_id;
	/**
	 * The name of the channel.
	 */
	public String name;
	/**
	 * The type of the channel.
	 */
	public String type;
	/**
	 * The position of the channel.
	 */
	public int position;
	/**
	 * Whether the channel is private or not.
	 */
	public boolean is_private;
	/**
	 * Array of permission overwrites.
	 */
	public OverwriteObject[] permission_overwrites;
	/**
	 * Topic of the channel.
	 */
	public String topic;
	/**
	 * ID of the last message sent in the channel.
	 */
	@JsonSerialize(using = IDSerializer.class)
	@JsonDeserialize(using = IDDeserializer.class)
	public Long last_message_id;
	/**
	 * When the last pin was made in the channel.
	 */
	public String last_pin_timestamp;
	/**
	 * Bitrate of the channel if it is voice type.
	 */
	public int bitrate;
	/**
	 * Maximum number of users allowed in the channel if it is voice type.
	 */
	public int user_limit;
	/**
	 * Recipients of the channel if it is private type.
	 */
	public UserObject[] recipients;
}
