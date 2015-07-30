package ch.opo.opoomcb.core.dao.builder.model;

/**
 * @author Paweł Łabuda
 */
public class OrderBy
{
   private String alias;

   private String column;

   public OrderBy(String column, String alias)
   {
      this.column = column;
      this.alias = alias;
   }
}
