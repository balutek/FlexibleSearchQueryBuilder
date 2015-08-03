/*
 * OPO-Net® Online-Shop
 * Copyright (c) 2000-2015 OPO Oeschger AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of OPO.
 */
package ch.opo.opoomcb.core.dao.builder.model;

import org.apache.commons.lang.StringUtils;

import static ch.opo.opoomcb.core.dao.builder.constants.QueryElements.*;

/**
 * @author Paweł Łabuda
 */

public class Table implements Renderable
{
   private String name;

   private String alias;

   public Table(String name)
   {
      this.name = name;
   }
   public Table(String name, String alias)
   {
      this.name = name;
      this.alias = alias;
   }

   @Override
   public void render(StringBuilder builder)
   {
      builder.append(name);
      if (StringUtils.isNotBlank(alias))
      {
         builder.append(SPACE)
            .append(AS)
            .append(SPACE)
            .append(alias);
      }
   }
}
