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
   private Column column;

   private List<Join> joinList;

   public From()
   {
      joinList = new ArrayList<Join>();
   }

   public void addJoin(Join join)
   {
      joinList.add(join);
   }

   public List<Join> getJoinList()
   {
      return joinList;
   }
}
