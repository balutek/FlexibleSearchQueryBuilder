/*
 * OPO-Net® Online-Shop
 * Copyright (c) 2000-2015 OPO Oeschger AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of OPO.
 */
package ch.opo.opoomcb.core.dao.builder.model;

/**
 * @author Paweł Łabuda
 */
public class QueryModel implements Renderable
{
   private Select select; // todo should change to List, and add Logic Operation List

   public QueryModel()
   {
   }

   public Select getLastSelect()
   {
      return select;
   }

   public From getLastFrom()
   {
      return getLastSelect().getLastFrom();
   }

   public Where getLastWhere()
   {
      return getLastSelect().getWhere();
   }

   public void setSelect(Select select)
   {
      this.select = select;
   }

   @Override
   public StringBuilder render(StringBuilder builder)
   {

      return builder;
   }
}
