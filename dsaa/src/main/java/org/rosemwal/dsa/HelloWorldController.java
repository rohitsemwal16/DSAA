/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
*/
package org.rosemwal.dsa;

import java.util.*;

//5d
public class HelloWorldController {



        public static void main(String[] args) {

            List<Integer> list = Arrays.asList(2, 4, 6, 8, 10);

            // Using forEach(Consumer action) to
            // print the elements of stream
            // in reverse order
            list.stream().forEach(i -> System.out.println(i));     }

//    private static void show() {
//            System.out.println("show");
//            throw new RuntimeException();
//    }


//
////        System.out.println("1");
////
////        synchronized (args) {
////            System.out.println("2");
////            try {
////                args.wait();
////            } catch (InterruptedException e) {
////            }
////        }
////            System.out.println("3");
//
//        HelloWorldController t1 = new HelloWorldController();
//        System.out.println(t1.getName());
//        t1.start();
//        t1.setName("Arun");
//        System.out.println(t1.getName());
//        }
//
//        public void run()   {
//        System.out.println("running");
//        }
    }
