package ch.opo.opoomcb.core.dao.builder.model.operation.compare.noparam.binary;

import ch.opo.opoomcb.core.dao.builder.model.Column;

/**
 * @author Paweł Łabuda
 */
public class Greater extends CompareTwoColumns
{
   public Greater(Column firstColumn, Column secondColumn)
   {
      super(firstColumn, secondColumn);
   }
}
