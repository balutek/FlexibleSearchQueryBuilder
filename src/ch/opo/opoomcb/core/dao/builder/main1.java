/*
 * OPO-Net® Online-Shop
 * Copyright (c) 2000-2015 OPO Oeschger AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of OPO.
 */
package ch.opo.opoomcb.core.dao.builder;

import ch.opo.opoomcb.core.dao.builder.balutekbuilders.Query;
import ch.opo.opoomcb.core.dao.builder.builders.QueryBuilder;
import ch.opo.opoomcb.core.dao.builder.model.QueryModel;

/**
 * @author Paweł Łabuda
 */
public class main1
{
   public static void main(String[] arg)
   {
//      QueryModel queryModel =
//         QueryBuilder
//            .selectDistinct()
//            .from("p", "Product")
//               .leftJoin("w", "Category")
//                  .on()
//                     .openBracket()
//                        .equals("p", "Product", "w", "Category")
//                        .and()
//                        .isNotNull("p", "Product")
//                     .closeBracket()
//                     .and()
//                     .isNull("ww", "aaaaa")
//            .where()
//               .like("alias", "www", "lala")
//               .or()
//               .openBracket()
//                  .endsWith("w", "wwwww", "key4")
//                  .and()
//                  .notEquals("alias", "ee", "key1")
//               .closeBracket()
//               .and()
//               .notEquals("alias", "ee", "key2")
//               .or()
//               .isIn("alias", "aaa", "key3")
//               .orderBy("alias1","www")
//            .getQuery();
//
//      System.out.println(queryModel.buildQuery() + "\n\n");
//
//      queryModel =
//         QueryBuilder
//            .selectDistinct()
//            .from("p", "Product")
//               .leftJoin("w", "Category")
//                  .on()
//                    .equals("p", "Product", "w", "Category")
//            .where()
//            .like("alias", "www", "lala")
//            .or()
//            .notEquals("alias", "ee", "alias2", "columnNAME")
//            .or()
//            .isIn("alias", "aaa", "key3")
//            .getQuery();

//      System.out.println(queryModel.buildQuery());
      Query.select().pk().from("from").join("joinedFirst").join("typecode").on().build();
   }
}
