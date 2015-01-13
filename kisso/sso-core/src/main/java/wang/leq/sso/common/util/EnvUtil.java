/**
 * Copyright (c) 2011-2014, hubin (243194995@qq.com).
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
package wang.leq.sso.common.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 获取系统环境变量工具类
 * <p>
 * @author   hubin
 * @Date	 2015-1-13 	 
 */
public class EnvUtil {

	private final static Logger logger = LoggerFactory.getLogger(EnvUtil.class);


	/**
	 * 返回当前系统变量的函数
	 * 结果放至 Properties
	 */
	public static Properties getEnv() throws Exception {
		Properties prop = new Properties();
		String OS = System.getProperty("os.name").toLowerCase();
		logger.info("os.name: {}", OS);
		Process p = null;
		if ( OS.indexOf("windows") > -1 ) {
			p = Runtime.getRuntime().exec("cmd /c set");
		}
		if ( OS.indexOf("linux") > -1 ) {
			p = Runtime.getRuntime().exec("sh -c set");
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line;
		while ( (line = br.readLine()) != null ) {
			int i = line.indexOf("=");
			if ( i > -1 ) {
				String key = line.substring(0, i);
				String value = line.substring(i + 1);
				prop.setProperty(key, value);
			}
		}
		return prop;
	}


	/**
	 * LINUX 编辑用法：
	 * #############################################
	 * vi /etc/profile
	 * ---------------------------------------------
	 * SSO_LOGIN=0
	 * export SSO_LOGIN
	 * ---------------------------------------------
	 * source /etc/profile
	 * #############################################
	 * 程序输入结果：0
	 */
	public static void main( String[] args ) {
		try {
			Properties p = EnvUtil.getEnv();
			//注意大小写，比如读取PATH，Linux下为PATH；Windows为Path。
			System.out.println(p.getProperty("SSO_LOGIN"));
		} catch ( Exception e ) {
			System.out.println(e);
		}
	}
}
