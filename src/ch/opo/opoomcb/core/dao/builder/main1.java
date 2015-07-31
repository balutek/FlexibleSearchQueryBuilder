/*
 * OPO-Net® Online-Shop
 * Copyright (c) 2000-2015 OPO Oeschger AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of OPO.
 */
package ch.opo.opoomcb.core.dao.builder;

import ch.opo.opoomcb.core.dao.builder.builders.QueryBuilder;
import ch.opo.opoomcb.core.dao.builder.model.QueryModel;

import java.util.ArrayList;

/**
 * @author Paweł Łabuda
 */
public class main1
{
   public static void main(String[] arg)
   {
      QueryModel queryModel =
         QueryBuilder
            .selectDistinct()
            .from("p", "Product")
               .leftJoin("w", "Category")
                  .on()
                     .openBracket()
                        .equals("p", "Product", "w", "Category")
                        .and()
                        .isNotNull("p", "Product")
                     .closeBracket()
                     .and()
                     .isNull("ww", "aaaaa")
            .where()
               .openBracket()
                  .like("alias", "www", "lala")
                  .or()
                  .openBracket()
                     .endWith("w", "wwwww", "huifdifjdkl")
                  .closeBracket()
                  .and()
                  .notEquals("alias", "ee", 3)
               .closeBracket()
               .and()
               .notEquals("alias", "ee", 4)
            .or()
            .isIn("alias", "aaa", new ArrayList<String>())
            .orderBy("alias1","www")
            .getQuery();

      if (queryModel == null)
      {
         for (int i = 0; i < 10; ++i)
         {
            System.out.println("lala");
         }
      }
   }
}
