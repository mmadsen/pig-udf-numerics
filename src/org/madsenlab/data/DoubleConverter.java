package org.madsenlab.data;


import org.apache.pig.EvalFunc;
import org.apache.pig.data.DataType;
import org.apache.pig.data.Tuple;
import org.apache.pig.impl.logicalLayer.schema.Schema;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * CLASS DESCRIPTION
 * <p/>
 * User: mark
 * Date: 10/12/13
 * Time: 2:26 PM
 */

public class DoubleConverter extends EvalFunc<String> {

    @Override
    public String exec(Tuple input) throws IOException {
        if (input == null || input.size() == 0) {
            return null;
        }
        try {
            Double num = (Double) input.get(0);
            if (num == null) {
                return null;
            }

            BigDecimal bigDecimal = new BigDecimal(num);
            return bigDecimal.toPlainString();
        }
        catch (Exception e) {
            throw new RuntimeException("DoubleConverter error", e);
        }
    }

    @Override
    public Schema outputSchema(Schema input) {
        return new Schema(new Schema.FieldSchema(null, DataType.CHARARRAY));
    }


}
