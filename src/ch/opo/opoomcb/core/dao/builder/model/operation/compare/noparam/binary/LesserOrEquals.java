package ch.opo.opoomcb.core.dao.builder.model.operation.compare.noparam.binary;

import ch.opo.opoomcb.core.dao.builder.model.Column;

/**
 * @author Paweł Łabuda
 */
public class LesserOrEquals extends CompareTwoColumns
{
   public LesserOrEquals(Column firstColumn, Column secondColumn)
   {
      super(firstColumn, secondColumn);
   }
}
