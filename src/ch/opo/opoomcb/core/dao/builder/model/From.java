/*
 * OPO-Net® Online-Shop
 * Copyright (c) 2000-2015 OPO Oeschger AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of OPO.
 */
package ch.opo.opoomcb.core.dao.builder.model;

import java.util.ArrayList;
import java.util.List;

import static ch.opo.opoomcb.core.dao.builder.constants.QueryElements.*;

/**
 * @author Paweł Łabuda
 */
public class From implements Renderable
{
   private Table table;

   private List<Join> joinList;

   public From(Table table)
   {
      this.table = table;
      joinList = new ArrayList<Join>();
   }

   public void addJoin(Join join)
   {
      joinList.add(join);
   }

   public Join getLastJoin()
   {
      if (joinList.size() > 0)
      {
         return joinList.get(joinList.size() - 1);
      }
      return null;
   }

   @Override
   public void render(StringBuilder builder)
   {
      builder.append(OPEN_CURLY_BRACKET);
      table.render(builder);
      for (Join join : joinList)
      {
         builder.append(SPACE);
         join.render(builder);
      }
      builder.append(CLOSE_CURLY_BRACKET)
         .append(SPACE);
   }
}
