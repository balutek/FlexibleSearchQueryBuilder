package ch.opo.opoomcb.core.dao.builder.model.operation.compare.noparam.unary;

import ch.opo.opoomcb.core.dao.builder.model.Column;

/**
 * @author Paweł Łabuda
 */
public class IsNull extends CompareOneColumn
{
   public IsNull(Column column)
   {
      super(column);
   }
}
