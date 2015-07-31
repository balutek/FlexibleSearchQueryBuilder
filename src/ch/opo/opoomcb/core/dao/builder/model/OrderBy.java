package ch.opo.opoomcb.core.dao.builder.model;

import static ch.opo.opoomcb.core.dao.builder.constants.QueryElements.*;


/**
 * @author Paweł Łabuda
 */
public class OrderBy implements Renderable
{
   private Column column;

   public OrderBy(Column column)
   {
      this.column = column;
   }

   @Override
   public void render(StringBuilder builder)
   {
      builder.append(SPACE)
         .append(ORDER_BY)
         .append(SPACE);
      column.render(builder);
   }
}
