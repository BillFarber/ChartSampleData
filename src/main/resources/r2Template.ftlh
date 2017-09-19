<mdr:Record Type="R2" xmlns:mdr="http://dtic.mil/mdr/record">
    <meta:Metadata xmlns:meta="http://dtic.mil/mdr/record/meta">
        <meta:AccessionNumber>${accessionNumber}</meta:AccessionNumber>
        <meta:CitationClassification>
            <meta:Code>U</meta:Code>
            <meta:Description>Unclassified</meta:Description>
        </meta:CitationClassification>
        <meta:CitationCreationDate>
            <meta:Date>2017-05-01</meta:Date>
            <meta:String>2017-05</meta:String>
        </meta:CitationCreationDate>
        <meta:Collections>
            <meta:Collection>R1</meta:Collection>
        </meta:Collections>
        <meta:DateCitationUpdated>
            <meta:Date>2017-06-01</meta:Date>
            <meta:String>2017-05</meta:String>
        </meta:DateCitationUpdated>
        <meta:DateOfSummary>
            <meta:Date>2017-04-01</meta:Date>
            <meta:String>2017-04</meta:String>
        </meta:DateOfSummary>
        <meta:DistributionCode>
            <meta:Code>C</meta:Code>
            <meta:Description>Distribution Unlimited</meta:Description>
        </meta:DistributionCode>
        <meta:DistributionReason>
            <meta:Code>PB</meta:Code>
            <meta:Description>Public and Foreign Release</meta:Description>
        </meta:DistributionReason>
        <meta:Entity>Budget</meta:Entity>
        <meta:IngestionDate>
            <meta:DateTime>2017-05-22T16:00:00-04:00</meta:DateTime>
        </meta:IngestionDate>
        <meta:OriginalJSONPath>/a/b</meta:OriginalJSONPath>
        <meta:OriginalXMLPath>/c/d</meta:OriginalXMLPath>
        <meta:ReportClassification>
            <meta:Code>U</meta:Code>
            <meta:Description>Unclassified</meta:Description>
        </meta:ReportClassification>
        <meta:ServiceAgencyAcronym>ARMY</meta:ServiceAgencyAcronym>
    </meta:Metadata>
    <mdr:PDF>
        <mdr:FullText></mdr:FullText>
        <mdr:FullTextBytes></mdr:FullTextBytes>
        <mdr:FullTextExists></mdr:FullTextExists>
        <mdr:FullTextIndexed></mdr:FullTextIndexed>
        <mdr:FullTextPath></mdr:FullTextPath>
    </mdr:PDF>
    <r2:ProgramElementList targetSchemaVersion="1.0" xmlns:r2="http://www.dtic.mil/comptroller/xml/schema/022009/r2">
        <r2:ProgramElement classification="UNCLASSIFIED" monetaryUnit="Millions">
            <r2:AppropriationCode>1</r2:AppropriationCode>
            <r2:AppropriationName>2</r2:AppropriationName>
            <r2:BudgetActivityNumber>3</r2:BudgetActivityNumber>
            <r2:BudgetActivityTitle>4</r2:BudgetActivityTitle>
            <r2:BudgetCycle>5</r2:BudgetCycle>
            <r2:BudgetYear>17</r2:BudgetYear>
            <r2:ProgramElementNumber>${programElementNumber}</r2:ProgramElementNumber>
            <r2:ProgramElementTitle>Test</r2:ProgramElementTitle>
            <r2:ServiceAgencyName>Army</r2:ServiceAgencyName>
        </r2:ProgramElement>
<#if useProgramElementNumber2>
        <r2:ProgramElement classification="UNCLASSIFIED" monetaryUnit="Millions">
            <r2:AppropriationCode>1</r2:AppropriationCode>
            <r2:AppropriationName>2</r2:AppropriationName>
            <r2:BudgetActivityNumber>3</r2:BudgetActivityNumber>
            <r2:BudgetActivityTitle>4</r2:BudgetActivityTitle>
            <r2:BudgetCycle>5</r2:BudgetCycle>
            <r2:BudgetYear>17</r2:BudgetYear>
            <r2:ProgramElementNumber>${programElementNumber2}</r2:ProgramElementNumber>
            <r2:ProgramElementTitle>Test</r2:ProgramElementTitle>
            <r2:ServiceAgencyName>Army</r2:ServiceAgencyName>
        </r2:ProgramElement>
</#if>
    </r2:ProgramElementList>
</mdr:Record>