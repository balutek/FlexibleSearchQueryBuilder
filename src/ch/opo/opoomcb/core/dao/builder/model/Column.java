/*
 * OPO-Net® Online-Shop
 * Copyright (c) 2000-2015 OPO Oeschger AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of OPO.
 */
package ch.opo.opoomcb.core.dao.builder.model;

import static ch.opo.opoomcb.core.dao.builder.constants.QueryElements.*;

/**
 * @author Paweł Łabuda
 */
public class Column implements Renderable
{
   private String name;

   private String alias;

   public Column(String name, String alias)
   {
      this.name = name;
      this.alias = alias;
   }

   @Override
   public void render(StringBuilder builder)
   {
      builder.append(OPEN_CURLY_BRACKET);
      if (alias != null)
      {
         builder.append(alias)
            .append(ALIAS_SEPARATOR);
      }
      builder.append(name)
         .append(CLOSE_CURLY_BRACKET);
   }
}
