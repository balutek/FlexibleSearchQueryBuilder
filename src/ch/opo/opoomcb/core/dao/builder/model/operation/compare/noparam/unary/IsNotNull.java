package ch.opo.opoomcb.core.dao.builder.model.operation.compare.noparam.unary;

import ch.opo.opoomcb.core.dao.builder.model.Column;

/**
 * @author Paweł Łabuda
 */
public class IsNotNull extends CompareOneColumn
{
   public IsNotNull(Column column)
   {
      super(column);
   }
}
