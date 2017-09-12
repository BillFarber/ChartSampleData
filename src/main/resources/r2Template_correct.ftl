<?xml version="1.0" encoding="UTF-8" standalone="no" ?>
<mdr:Record Type="R2" xmlns:mdr="http://dtic.mil/mdr/record">
    <meta:Metadata xmlns:meta="http://dtic.mil/mdr/record/meta">
        <meta:AccessionNumber>${accessionNumber}</meta:AccessionNumber>
        <#if citationClassification?? >
        <meta:CitationClassification>
            <meta:Code>${citationClassification.code}</meta:Code>
            <meta:Description>${citationClassification.description}</meta:Description>
        </meta:CitationClassification>
        </#if>
        <meta:CitationCreationDate>
            <meta:Date>2017-05-01</meta:Date>
            <meta:String>2017-05</meta:String>
        </meta:CitationCreationDate>
        <meta:Collections>
            <#if isR1() >
                <meta:Collection>R1</meta:Collection>
            </#if>
            <#if fullTextExists == 1 || !isR1()>
                <meta:Collection>R2</meta:Collection>
            </#if>
        </meta:Collections>
        <meta:DateCitationUpdated>
            <meta:Date>2017-06-01</meta:Date>
            <meta:String>2017-05</meta:String>
        </meta:DateCitationUpdated>
        <meta:DateOfSummary>
            <meta:Date>2017-04-01</meta:Date>
            <meta:String>2017-04</meta:String>
        </meta:DateOfSummary>
        <#if distributionCode?? >
        <meta:DistributionCode>
            <meta:Code>${distributionCode.code}</meta:Code>
            <meta:Description>${distributionCode.description}</meta:Description>
        </meta:DistributionCode>
        </#if>
        <#if distributionReason?? >
        <meta:DistributionReason>
            <meta:Code>${distributionReason.code}</meta:Code>
            <meta:Description>${distributionReason.description}</meta:Description>
        </meta:DistributionReason>
        </#if>
        <meta:Entity>Budget</meta:Entity>
        <meta:IngestionDate>
            <meta:DateTime>2017-05-22T16:00:00-04:00</meta:DateTime>
        </meta:IngestionDate>
        <#if originalJsonPath?? >
        <meta:OriginalJSONPath>${originalJsonPath}</meta:OriginalJSONPath>
        </#if>
        <#if originalXmlPath?? >
        <meta:OriginalXMLPath>${originalXmlPath}</meta:OriginalXMLPath>
        </#if>
        <#if reportClassification?? >
        <meta:ReportClassification>
            <meta:Code>${reportClassification.code}</meta:Code>
            <meta:Description>${reportClassification.description}</meta:Description>
        </meta:ReportClassification>
        </#if>
        <meta:ServiceAgencyAcronym>ARMY</meta:ServiceAgencyAcronym>
    </meta:Metadata>
    <mdr:PDF>
        <mdr:FullText>${fullText}</mdr:FullText>
        <mdr:FullTextBytes>${fullTextBytes}</mdr:FullTextBytes>
        <mdr:FullTextExists>${fullTextExists}</mdr:FullTextExists>
        <mdr:FullTextIndexed>${fullTextIndexed}</mdr:FullTextIndexed>
        <mdr:FullTextPath>${fullTextPath}</mdr:FullTextPath>
    </mdr:PDF>
    <r2:ProgramElementList targetSchemaVersion="1.0" xmlns:r2="http://www.dtic.mil/comptroller/xml/schema/022009/r2">
        <#list programElements as programElement>
        <r2:ProgramElement classification="UNCLASSIFIED" monetaryUnit="Millions">
            <r2:AppropriationCode>${programElement.appropriationCode}</r2:AppropriationCode>
            <r2:AppropriationName>${programElement.appropriationName}</r2:AppropriationName>
            <r2:BudgetActivityNumber>${programElement.budgetActivityNumber}</r2:BudgetActivityNumber>
            <r2:BudgetActivityTitle>${programElement.budgetActivityTitle}</r2:BudgetActivityTitle>
            <r2:BudgetCycle>${programElement.budgetCycle}</r2:BudgetCycle>
            <r2:BudgetYear>${programElement.budgetYear}</r2:BudgetYear>
            <r2:ProgramElementNumber>${programElement.programElementNumber}</r2:ProgramElementNumber>
            <r2:ProgramElementTitle>${programElement.programElementTitle}</r2:ProgramElementTitle>
            <r2:ServiceAgencyName>${programElement.serviceAgencyName}</r2:ServiceAgencyName>
        </r2:ProgramElement>
        </#list>
    </r2:ProgramElementList>
    <#if raw?? >
    <R2:Raw xmlns:R2="http://dtic.mil/mdr/record/R2">${raw}</R2:Raw>
    </#if>
</mdr:Record>