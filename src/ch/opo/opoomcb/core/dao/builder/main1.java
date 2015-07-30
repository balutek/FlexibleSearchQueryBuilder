/*
 * OPO-Net® Online-Shop
 * Copyright (c) 2000-2015 OPO Oeschger AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of OPO.
 */
package ch.opo.opoomcb.core.dao.builder;

/**
 * @author Paweł Łabuda
 */
public class main1
{
   public static void main(String[] arg)
   {
      System.out.println(
         QueryBuilder
            .selectDistinct()
            .from("p", "Product")
               .leftJoin("w", "Category")
                  .on()
                     .equals("p", "Product", "w", "Category")
                     .and()
                     .isNotNull("p", "Product")
            .where()
               .openBracket()
                  .like("www", "lala")
                  .or()
                  .notEquals("ee", 3)
               .closeBracket()
               .and()
               .notEquals("ee", 4)
               .or()
               .isIn("aaa", 1, 2, 3, 4)
            .orderBy("www")
            .build()
      );
   }
}
