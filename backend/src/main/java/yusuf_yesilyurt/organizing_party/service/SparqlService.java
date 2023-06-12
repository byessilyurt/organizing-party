package yusuf_yesilyurt.organizing_party.service;

import org.apache.jena.query.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SparqlService {

    private final String datasetURL = "http://localhost:3030/organizingparty/sparql";

    public List<String> runQueries() {
        List<String> results = new ArrayList<>();

        // Query 1: Retrieve the addresses of all event places
        String query1 = "PREFIX op: <http://www.###.com#>\n" +
                "SELECT ?address\n" +
                "WHERE {\n" +
                "  ?eventPlace a op:EventPlace.\n" +
                "  ?eventPlace op:hasAddress ?address.\n" +
                "}";
        results.add(runQuery(query1));

        // Query 2: Retrieve the beverage types and their prices
        String query2 = "PREFIX op: <http://www.###.com/ontology#>\n" +
                "SELECT ?beverageType ?price\n" +
                "WHERE {\n" +
                "  ?beverage a op:Beverage.\n" +
                "  ?beverage op:hasBeverageType ?beverageType.\n" +
                "  ?beverage op:hasPrice ?price.\n" +
                "}";
        results.add(runQuery(query2));

        // Query 3: Retrieve the names and roles of all floor assistants
        String query3 = "PREFIX op: <http://www.###.com/ontology#>\n" +
                "SELECT ?name ?role\n" +
                "WHERE {\n" +
                "  ?assistant a op:FloorAssistant.\n" +
                "  ?assistant op:hasName ?name.\n" +
                "  ?assistant op:hasRole ?role.\n" +
                "}";
        results.add(runQuery(query3));

        // Query 4: Retrieve the event places with a capacity greater than 200
        String query4 = "PREFIX op: <http://www.###.com/ontology#>\n" +
                "SELECT ?eventPlace\n" +
                "WHERE {\n" +
                "  ?eventPlace a op:EventPlace.\n" +
                "  ?eventPlace op:hasCapacity ?capacity.\n" +
                "  FILTER(?capacity > 200)\n" +
                "}";
        results.add(runQuery(query4));

        // Query 5: Retrieve the event risks with a high risk level
        String query5 = "PREFIX op: <http://www.organizingparty.com/ontology#>\n" +
                "SELECT ?risk\n" +
                "WHERE {\n" +
                "  ?risk a op:EventRisk.\n" +
                "  ?risk op:hasRiskLevel \"High\".\n" +
                "}";
        results.add(runQuery(query5));

        return results;
    }

    private String runQuery(String queryString) {
        try (QueryExecution queryExecution = QueryExecutionFactory.sparqlService(datasetURL, queryString)) {
            ResultSet resultSet = queryExecution.execSelect();
            return ResultSetFormatter.asText(resultSet);
        }
    }
}
