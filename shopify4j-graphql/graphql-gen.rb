#!/usr/bin/ruby

require 'graphql_java_gen'
require 'graphql_schema'
require 'json'

introspection_result = File.read("schema/admin-schema@2021-01.json")
schema = GraphQLSchema.new(JSON.parse(introspection_result))

GraphQLJavaGen.new(schema,
  package_name: "codemeans.shopify4j.graphql.gen",
 nest_under: 'AdminGraphql',
  version: '2021-01',
  custom_scalars: [
    GraphQLJavaGen::Scalar.new(
      type_name: 'Decimal',
      java_type: 'BigDecimal',
      deserialize_expr: ->(expr) { "new BigDecimal(jsonAsString(#{expr}, key))" },
      imports: ['java.math.BigDecimal'],
    ),
    GraphQLJavaGen::Scalar.new(
      type_name: 'Money',
      java_type: 'BigDecimal',
      deserialize_expr: ->(expr) { "new BigDecimal(jsonAsString(#{expr}, key))" },
      imports: ['java.math.BigDecimal'],
    ),
    GraphQLJavaGen::Scalar.new(
      type_name: 'DateTime',
      java_type: 'DateTime',
      deserialize_expr: ->(expr) { "DateTime.parse(jsonAsString(#{expr}, key))" },
      imports: ['org.joda.time.DateTime'],
    )
  ]
).save_granular("#{Dir.pwd}/src/main/java/codemeans/shopify4j/graphql/gen/")
