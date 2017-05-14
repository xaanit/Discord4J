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
import sx.blah.discord.api.internal.IDArrayDeserializer;
import sx.blah.discord.api.internal.IDArraySerializer;

/**
 * Represents a json member object.
 */
public class MemberObject {
	/**
	 * The user associated with this member.
	 */
	public UserObject user;
	/**
	 * The nickname of the member.
	 */
	public String nick;
	/**
	 * The roles of the member.
	 */
	@JsonSerialize(using = IDArraySerializer.class)
	@JsonDeserialize(using = IDArrayDeserializer.class)
	public long[] roles;
	/**
	 * When the member joined the guild.
	 */
	public String joined_at;
	/**
	 * Whether this member is deafened.
	 */
	public boolean deaf;
	/**
	 * Whether this member is muted.
	 */
	public boolean mute;

	public MemberObject() {}

	public MemberObject(UserObject user, long[] roles) {
		this.user = user;
		this.roles = roles;
	}
}
