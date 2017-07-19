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

package sx.blah.discord.handle.impl.obj;

import com.fasterxml.jackson.core.JsonProcessingException;
import sx.blah.discord.Discord4J;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.IShard;
import sx.blah.discord.api.internal.DiscordClientImpl;
import sx.blah.discord.api.internal.DiscordEndpoints;
import sx.blah.discord.api.internal.DiscordUtils;
import sx.blah.discord.api.internal.json.requests.WebhookEditRequest;
import sx.blah.discord.handle.obj.*;
import sx.blah.discord.util.Image;
import sx.blah.discord.util.LogMarkers;
import sx.blah.discord.util.PermissionUtils;

import java.util.Objects;

public class Webhook implements IWebhook {

	private final long id;
	private final IChannel channel;
	private final IUser author;
	private final String name;
	private final String avatar;
	private final String token;

	public Webhook(long id, IChannel channel, IUser author, String name, String avatar, String token) {
		this.id = id;
		this.channel = channel;
		this.author = author;
		this.name = name;
		this.avatar = avatar;
		this.token = token;
	}

	@Override
	public void changeDefaultName(String name) {
		edit(new WebhookEditRequest.Builder().name(name).build());
	}

	@Override
	public void changeDefaultAvatar(Image avatar) {
		changeDefaultAvatar(avatar.getData());
	}

	@Override
	public void changeDefaultAvatar(String avatar) {
		edit(new WebhookEditRequest.Builder().avatar(avatar).build());
	}

	@Override
	public void edit(String name, String avatar) {
		edit(new WebhookEditRequest.Builder().name(name).avatar(avatar).build());
	}

	private void edit(WebhookEditRequest request) {
		PermissionUtils.requirePermissions(getChannel(), getClient().getOurUser(), Permissions.MANAGE_WEBHOOKS);

		try {
			((DiscordClientImpl) getClient()).REQUESTS.PATCH.makeRequest(
					DiscordEndpoints.WEBHOOKS + getStringID(),
					DiscordUtils.MAPPER_NO_NULLS.writeValueAsString(request));
		} catch (JsonProcessingException e) {
			Discord4J.LOGGER.error(LogMarkers.HANDLE, "Discord4J Internal Exception", e);
		}
	}

	@Override
	public IGuild getGuild() {
		return getChannel().getGuild();
	}

	@Override
	public IChannel getChannel() {
		return channel;
	}

	@Override
	public IUser getAuthor() {
		return author;
	}

	@Override
	public String getDefaultName() {
		return name;
	}

	@Override
	public String getDefaultAvatar() {
		return avatar;
	}

	@Override
	public String getToken() {
		return token;
	}

	@Override
	public void delete() {
		PermissionUtils.requirePermissions(getChannel(), getClient().getOurUser(), Permissions.MANAGE_WEBHOOKS);

		((DiscordClientImpl) getClient()).REQUESTS.DELETE.makeRequest(DiscordEndpoints.WEBHOOKS + getStringID());
	}

	@Override
	public boolean isDeleted() {
		return getChannel().getWebhookByID(getLongID()) != this;
	}

	@Override
	public long getLongID() {
		return id;
	}

	@Override
	public IShard getShard() {
		return getChannel().getShard();
	}

	@Override
	public IDiscordClient getClient() {
		return getChannel().getClient();
	}

	@Override
	public IWebhook copy() {
		return new Webhook(id, channel, author, name, avatar, token);
	}

	@Override
	public String toString() {
		return "Webhook(name: " + getStringID() + ")";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		return DiscordUtils.equals(this, obj);
	}
}
