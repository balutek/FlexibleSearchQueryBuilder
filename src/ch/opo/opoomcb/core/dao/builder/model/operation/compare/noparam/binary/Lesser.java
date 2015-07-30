package ch.opo.opoomcb.core.dao.builder.model.operation.compare.noparam.binary;

import ch.opo.opoomcb.core.dao.builder.model.Column;

/**
 * @author Paweł Łabuda
 */
public class Lesser extends CompareTwoColumns
{
   public Lesser(Column firstColumn, Column secondColumn)
   {
      super(firstColumn, secondColumn);
   }
}
