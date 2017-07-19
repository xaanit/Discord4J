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

package sx.blah.discord.api.internal.json.requests;

/**
 * This is sent to request that a webhook be edited.
 */
public class WebhookEditRequest {

	public static class Builder {

		private String name;
		private String avatar;

		/**
		 * Sets the new name of the webhook.
		 *
		 * @param name The new name
		 * @return This builder, for chaining.
		 */
		public Builder name(String name) {
			this.name = name;
			return this;
		}

		/**
		 * Sets the new avatar of the webhook.
		 *
		 * @param avatar The new avatar.
		 * @return This builder, for chaining.
		 */
		public Builder avatar(String avatar) {
			this.avatar = avatar;
			return this;
		}

		/**
		 * Builds the webhook edit request.
		 *
		 * @return The webhook edit request.
		 */
		public WebhookEditRequest build() {
			return new WebhookEditRequest(name, avatar);
		}

	}

	/**
	 * The new name of the webhook.
	 */
	private final String name;

	/**
	 * The new icon.
	 */
	private final String avatar;

	private WebhookEditRequest(String name, String avatar) {
		this.name = name;
		this.avatar = avatar;
	}
}
