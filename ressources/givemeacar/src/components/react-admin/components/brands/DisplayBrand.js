import { Datagrid, Filter, List, useTranslate, SearchInput, TextField } from "react-admin";
import * as React from "react";
const PostFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
    </Filter>
);
const DisplayBrand = (props) => {

    const t = useTranslate();

    return <List {...props} title={t('custom.brands')} filters={<PostFilter />}>
        <Datagrid rowClick="edit">
            <TextField label={t('custom.id')} source="id" />

            <TextField label={t('custom.name')} source="name" />
        </Datagrid>
    </List>
}

export default DisplayBrand