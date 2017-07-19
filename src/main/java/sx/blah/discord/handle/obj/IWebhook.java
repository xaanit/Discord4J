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

package sx.blah.discord.handle.obj;

import sx.blah.discord.util.Image;

/**
 * A webhook in a Discord text channel.
 */
public interface IWebhook extends IDiscordObject<IWebhook> {

	/**
	 * Changes the default name of the webhook.
	 *
	 * @param name The new default name.
	 */
	void changeDefaultName(String name);

	/**
	 * Changes the default avatar of the webhook.
	 *
	 * @param avatar The new default avatar.
	 */
	void changeDefaultAvatar(Image avatar);

	/**
	 * Changes the default avatar of the webhook.
	 *
	 * @param avatar The new default avatar.
	 */
	void changeDefaultAvatar(String avatar);

	/**
	 * Changes the default name and avatar of the webhook.
	 *
	 * @param name The new default name.
	 * @param avatar The new default avatar.
	 */
	void edit(String name, String avatar);

	/**
	 * Gets the guild the webhook's channel belongs to.
	 *
	 * @return The guild the webhook's channel belongs to.
	 */
	IGuild getGuild();

	/**
	 * Gets the channel the webhook belongs to.
	 *
	 * @return The channel the webhook belongs to.
	 */
	IChannel getChannel();

	/**
	 * Gets the user who created the webhook.
	 *
	 * @return The user who created the webhook.
	 */
	IUser getAuthor();

	/**
	 * Gets the default name of the webhook.
	 *
	 * @return The default name of the webhook.
	 */
	String getDefaultName();

	/**
	 * Gets the default avatar of the webhook.
	 *
	 * @return The default avatar of the webhook.
	 */
	String getDefaultAvatar();

	/**
	 * Gets the webhook's secure token.
	 *
	 * @return The webhook's secure token.
	 */
	String getToken();

	/**
	 * Deletes the webhook.
	 */
	void delete();

	/**
	 * Gets whether the webhook has been deleted.
	 *
	 * @return Whether the webhook has been deleted.
	 */
	boolean isDeleted();
}
