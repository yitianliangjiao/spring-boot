/*
 * Copyright 2002-2018 the original author or authors.
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

package com.wrh.springboot;

import org.springframework.stereotype.Component;


/**
 * 
 * @author Administrator
 * @since 4.3
 */
@Component
public class DemoA {
	private Integer id;  
    
    private DemoB demob;  
    
    
    public DemoA(DemoB demob){
    	
    }
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	

	
	/**
	 * @return the demob
	 */
	public DemoB getDemob() {
		return demob;
	}


	
	/**
	 * @param demob the demob to set
	 */
	public void setDemob(DemoB demob) {
		this.demob = demob;
	}


	public void say(){
    	System.out.println("i am Demoa");
    	demob.say();
    	System.out.println("i am Demoa");
    }
}
