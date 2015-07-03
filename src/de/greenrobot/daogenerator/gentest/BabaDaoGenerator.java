/*
 * Copyright (C) 2011 Markus Junginger, greenrobot (http://greenrobot.de)
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
package de.greenrobot.daogenerator.gentest;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class BabaDaoGenerator {

	public static void main(String[] args) throws Exception {
		
		/**
		 * 版本1:搜索
		 * 版本2：好友
		 */
		Schema schema = new Schema(2, "com.wise.baba.db.dao");

		addSuggestion(schema);
		addFriendData(schema);
		addFriendAuth(schema);

		new DaoGenerator().generateAll(schema, "../baba/src");
	}


	/**
	 * 百度搜索建议词表
	 * @param schema
	 */
	
	private static void addSuggestion(Schema schema) {
		Entity suggestion = schema.addEntity("Suggestion");
		suggestion.addIntProperty("type");
		suggestion.addStringProperty("key");
		suggestion.addStringProperty("city");
		suggestion.addStringProperty("district");
		suggestion.addDateProperty("date");
	}
	
	
	/**
	 * 好友列表
	 * @param schema
	 */
	private static void addFriendData(Schema schema) {
		Entity friendList = schema.addEntity("FriendData");
		friendList.addStringProperty("create_time");
		friendList.addIntProperty("sex");
	    friendList.addStringProperty("logo");
	    friendList.addStringProperty("friend_name");
	    friendList.addIntProperty("friend_type");
	    friendList.addIntProperty("friend_id");
	    friendList.addIntProperty("user_id");
	    friendList.addIntProperty("friend_relat_id");
	    friendList.addStringProperty("Group_letter");
	   // friendList.addStringProperty("rights");//保存json字符串
	}
	
	/**
	 * 权限表
	 * @param schema
	 */
	private static void addAuthorization(Schema schema) {
		Entity auth = schema.addEntity("Authorization");
		auth.addIntProperty("authCode");
		auth.addStringProperty("des");
		auth.addStringProperty("des1");
	}
	
	/**
	 * 好友，权限对应表
	 * @param schema
	 */
	private static void addFriendAuth(Schema schema) {
		Entity friendAuth = schema.addEntity("FriendAuth");
		friendAuth.addStringProperty("id");
		friendAuth.addStringProperty("friendId");
		friendAuth.addIntProperty("authCode");
	}
	
	

}
