import { Datagrid, Filter, List, ReferenceInput, SearchInput, TextField, useTranslate } from "react-admin";
import * as React from "react";

const PostFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
        <ReferenceInput source="name" reference="agencies" allowEmpty>
            <SearchInput optionText="name" />
        </ReferenceInput>
        <ReferenceInput source="city_id" reference="cities" allowEmpty>
            <SearchInput optionText="name" />
        </ReferenceInput>
        <ReferenceInput source="street_id" reference="streets" allowEmpty>
            <SearchInput optionText="name" />
        </ReferenceInput>
    </Filter>
);

const DisplayAgency = (props) => {

    const t = useTranslate();

    return <List {...props} title={t('word.agencies')} filters={<PostFilter />}>
        <Datagrid rowClick="edit">

            <TextField source="id" label={t("word.id")} />

            <TextField source="name" label={t("word.name")} />

            <TextField source="address" label={t("word.address")} />
        </Datagrid>
    </List>
}

export default DisplayAgency