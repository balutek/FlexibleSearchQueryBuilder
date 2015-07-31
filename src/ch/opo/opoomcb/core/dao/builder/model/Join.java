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
public class Join implements Renderable
{
   private Table table;

   protected On on;

   public Join(Table table)
   {
      this.table = table;
   }

   public Table getTable()
   {
      return table;
   }

   public void setOn(On on)
   {
      this.on = on;
   }

   public On getOn()
   {
      return on;
   }

   @Override
   public void render(StringBuilder builder)
   {
      builder.append(JOIN)
         .append(SPACE);
      table.render(builder);
      builder.append(SPACE);
      on.render(builder);
   }
}
