package org.kairosdb.plugin.rabbitmq.parsers;

import java.util.List;
import java.util.Map;
import java.util.SortedMap;

public interface Parser
{
    Message parse(byte[] data) throws ParserException;
    String[] getContentTypes();

    class ParserException extends Exception
    {
        public ParserException(Throwable throwable)
        {
            super(throwable);
        }
        public ParserException(String message)
        {
            super(message);
        }
    }

    class InvalidContentTypeException extends Exception
    {

    }

    class Message
    {
        public String metric;
        public List<DataPoints> datapoints;

        public static class DataPoints
        {
            public Map<String, String> tags;
            public SortedMap<Long, String> values;
        }
    }
}
