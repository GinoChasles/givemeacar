import { Datagrid, Filter, List, TextField, SearchInput, useTranslate } from "react-admin";
import * as React from "react";

const PostFilter = (props) => (
    <Filter {...props}>
        <SearchInput source="q" alwaysOn />
    </Filter>
);

const DisplayColor = (props) => {

    const t = useTranslate();

    return <List {...props} title={t('custom.colors')} filters={<PostFilter />}>
        <Datagrid rowClick="edit">
            <TextField label={t('custom.id')} source="id" />

            <TextField label={t('custom.name')} source="name" />
        </Datagrid>
    </List>
}
export default DisplayColor