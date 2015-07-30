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

/**
 * @author Paweł Łabuda
 */
public class From
{
   private Table table;

   private List<Join> joinList;

   public From(Table table)
   {
      this.table = table;
      joinList = new ArrayList<Join>();
   }

   public Table getTable()
   {
      return table;
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

   public List<Join> getJoinList()
   {
      return joinList;
   }
}
